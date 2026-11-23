
# IPL Auction Arena - V1 Requirements

## Product
Multiplayer browser-based cricket auction simulation.

## Participants
- Minimum: 3 ready participants.
- Maximum: 10 participants.
- Host automatically participates and can bid.
- Each participant owns one unique custom team.

## Team Rules
- Custom teams only.
- Minimum squad size: 15.
- Maximum squad size: 25.

## Auction Modes
- Classic: Host selects the next player.
- Automatic: Backend selects the next player.
- Participants manually place bids in both modes.

## Auction Rules
- Simplified custom auction rules.
- Fixed configurable purse and bid increments.
- Accepted bids reset the full configured timer.
- Rejected bids do not reset the timer.
- Host manually selects unsold players for another chance.
- Sold players cannot be re-entered.

## Player Data
- ODI, T20I and Test statistics.
- Competition-specific statistics.
- World Cup editions combined by default.
- Format-specific retirement status.
- Missing statistics must not be treated as zero.

## Additional Features
- Real-time bidding.
- Voice communication using LiveKit.
- AI cricket statistics assistant.

## V1 Exclusions
- AI auto-bidding.
- Spectator mode.
- Auction replay.
- Native mobile application.
- Multiple simultaneous auctions per user.
